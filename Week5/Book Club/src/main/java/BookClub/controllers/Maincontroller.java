package BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import BookClub.models.Book;
import BookClub.models.LoginUser;
import BookClub.models.User;
import BookClub.services.BookService;
import BookClub.services.UserService;

@Controller
public class Maincontroller {
	@Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
   
	@GetMapping("/")
		public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
   
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
	
		User user = userService.register(newUser, result);
	   	
	
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
	
		session.setAttribute("userId", user.getId());
		
		return "redirect:/dashboard";
	}
   
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
	
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/dashboard";
	}
   
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
	   	
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		   	
		model.addAttribute("books", bookService.getAllBooks());
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		
		return "dashboard.jsp";
	}
   
	@GetMapping("/addBook")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
	
		User user = userService.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		
		return "addbook.jsp";
	}
   
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	
		if (result.hasErrors()) {
			return "addbook.jsp";
		}
		
		bookService.create(book);
		
		return "redirect:/dashboard";
	}
   
	@GetMapping("/books/{id}/edit")
	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
	
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Book book = bookService.getById(id);
		model.addAttribute("book", book);
		
		return "editbook.jsp";
	}
   
	@GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Book book = bookService.getById(id);
		model.addAttribute("book", book);
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		
		return "showbook.jsp";
	}
   
	@PutMapping("/books/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	
		if (result.hasErrors()) {
			return "editPage.jsp";
		}

		bookService.update(book);
		
		return "redirect:/dashboard";
	}
   
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
