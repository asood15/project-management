package com.ashima.pma.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController implements ErrorController {

	@GetMapping("/error")
	public String getError(HttpServletRequest req) {
		Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			int code = Integer.valueOf(status.toString());
			if (code == HttpStatus.NOT_FOUND.value()) {
				return "errors/error-404";
			} else if (code == HttpStatus.FORBIDDEN.value()) {
				return "errors/error-403";
			} else if (code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "errors/error-500";
			}
		}
		return "errors/error";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
}
