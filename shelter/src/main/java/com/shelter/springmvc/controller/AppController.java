package com.shelter.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shelter.springmvc.model.Adoption;
import com.shelter.springmvc.model.Animal;
import com.shelter.springmvc.model.User;
import com.shelter.springmvc.model.UserProfile;
import com.shelter.springmvc.service.AdoptionService;
import com.shelter.springmvc.service.AnimalService;
import com.shelter.springmvc.service.UserProfileService;
import com.shelter.springmvc.service.UserService;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	AnimalService animalService;
	
	@Autowired
	AdoptionService adoptionService;

	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "mainPage";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/main";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}

///Animal Management
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/addanimal" }, method = RequestMethod.GET)
	public String newAnimal(ModelMap model) {
		Animal animal = new Animal();
		model.addAttribute("animal", animal);
		/*
		model.addAttribute("loggedinuser", getPrincipal());
		*/

		model.addAttribute("edit", false);
		return "addanimal";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving animal in database. It also validates the user input
	 */
	@RequestMapping(value = { "/addanimal" }, method = RequestMethod.POST)
	public String saveAnimal(@Valid Animal animal, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "mainPage";
		}
		
		animalService.saveAnimal(animal);

		model.addAttribute("success", "Animal " + animal.getaName() + " "+ animal.getSpecies() + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	/**
	 * This method will list all existing animals.
	 */
	@RequestMapping(value = { "/animalslist" }, method = RequestMethod.GET)
	public String listAnimals(ModelMap model) {

		List<Animal> animals = animalService.findAllAnimals();
		model.addAttribute("animals", animals);
		model.addAttribute("loggedinuser", getPrincipal());
		return "animalslist";
	}
	
	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/adopt-pet-{id}" }, method = RequestMethod.GET)
	public String adoptPet(@PathVariable Integer id, ModelMap model) {
		Animal animal = animalService.findById(id);
		model.addAttribute("adoption", new Adoption());

		model.addAttribute("animal", animal);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		//Adoption adopt = adoptionService.findById(id);
		//model.addAttribute(adopt);
		return "adoptAnimal";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving animal in database. It also validates the user input
	 */
	@RequestMapping(value = { "/adopt-pet-{id}" }, method = RequestMethod.POST)
	public String saveAdoption(@PathVariable Integer id,@Valid Adoption adoption, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Result: "+result.toString());

			logger.info("Houston, we have a problem.");
			return "mainPage";
		}
		
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		
		adoption.setAdoptDate(currentTime);
		adoptionService.saveAdoption(adoption);
		
		model.addAttribute("success", "Animal " + adoption.getaName() + " "+ adoption.getSpecies() + " is adopted to "+adoption.getAdopterName() +" successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		
		animalService.deleteAnimalById(id);
		logger.info("Adopted Pet: {}",adoption.getaName(),adoption.getAge(),adoption.getBreed(),adoption.getSpecies(),adoption.getAdopterName(),adoption.getAdoptDate(),
				adoption.getAddress(),adoption.getTelnum());
		
		return "registrationsuccess";
	}
	
	/**
	 * This method will list all existing adopted animals.
	 */
	@RequestMapping(value = { "/adoptedlist" }, method = RequestMethod.GET)
	public String listAdoptedAnimals(ModelMap model) {

		List<Adoption> adoptions = adoptionService.findAllAdoptions();
		model.addAttribute("adoptions", adoptions);
		model.addAttribute("loggedinuser", getPrincipal());
		return "adoptedlist";
	}
	
	/**
	 * This goes to about page
	 */
	@RequestMapping(value = { "/no-sidebar" }, method = RequestMethod.GET)
	public String about(ModelMap model) {

		return "no-sidebar";
	}
	@RequestMapping(value = { "/return" }, method = RequestMethod.POST)
	public String registrationSuccess(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		return "/";
	}
	
	@RequestMapping(value = { "/searchAnimal" }, method = RequestMethod.GET)
	public String searchAnimal(ModelMap model) {

		return "searchAnimal";
	}
	
	@RequestMapping("/looseSearch.do")
	public @ResponseBody List<Animal> performLooseSearch(@RequestParam("CHARS")String chars)
	{
		return animalService.searchAnimal(chars);
	}
	
	
	//Add animal by json
	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/addjanimal" }, method = RequestMethod.GET)
	public String newJAnimal(ModelMap model) {
		Animal animal = new Animal();
		model.addAttribute("animal", animal);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("edit", false);
		return "addanimal";
	}
	
	@RequestMapping(value="/submitForm", method = RequestMethod.POST)
    public @ResponseBody Animal  submittedFromData(@RequestBody Animal animal, HttpServletRequest request) {
		animalService.saveAnimal(animal);
		return animal;
	}	
	
}