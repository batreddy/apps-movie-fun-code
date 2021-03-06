package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ctsuser1 on 9/11/17.
 */

@Controller
public class HomeController {

    private MoviesBean moviesBean;

    @Autowired
    public HomeController(MoviesBean moviesBean) {
        this.moviesBean = moviesBean;
    }

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/setup")
    @Transactional
    public ModelAndView setUp(List<Movie> model) {

        moviesBean.addMovie(new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005));
        moviesBean.addMovie(new Movie("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004));
        moviesBean.addMovie(new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003));
        moviesBean.addMovie(new Movie("I-Spy", "Betty Thomas", "Adventure", 5, 2002));
        moviesBean.addMovie(new Movie("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001));
        moviesBean.addMovie(new Movie("Zoolander", "Ben Stiller", "Comedy", 6, 2001));
        moviesBean.addMovie(new Movie("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000));

        List<Movie> movies = moviesBean.getMovies();
        ModelAndView mv = new ModelAndView("setup");
        mv.addObject("movies", movies);

        return mv;
        //return "setup";

    }


}
