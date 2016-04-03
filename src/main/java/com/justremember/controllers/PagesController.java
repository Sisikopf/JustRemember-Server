package com.justremember.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andrey on 03.04.2016.
 */
@Controller
public class PagesController {

    @RequestMapping(value = "/index")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/notes")
    public String getNotesPage() {
        return "notes";
    }
}
