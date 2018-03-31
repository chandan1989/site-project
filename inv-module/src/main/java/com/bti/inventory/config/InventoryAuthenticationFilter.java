package com.bti.inventory.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bti.inventory.dto.UserSessionDto;
import com.bti.inventory.rest.UserServiceClient;

@Component
public class InventoryAuthenticationFilter {//extends OncePerRequestFilter {

	@Autowired
	private UserServiceClient client;

	//@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String URI = request.getRequestURI();
		// Urls which need not be autohrized add here.
		boolean allowedEndpoint = URI.startsWith("/actuator/");

		if (allowedEndpoint) {
			filterChain.doFilter(request, response);
		} else {
			boolean missingSessionAttrib = checkForMissingAttrib(request);
			if (missingSessionAttrib) {
				response.sendError(401, "Not Authorized");
			} else {
				UserSessionDto dto = getUserSession(request);
				ResponseEntity<Boolean> resp = client.validateSession(dto);
				if (resp.getBody()) {
					filterChain.doFilter(request, response);
				} else {
					response.sendError(401, "Not Authorized");
				}
			}

		}

	}

	private boolean checkForMissingAttrib(HttpServletRequest request) {
		boolean missingSessionAttrib = false;
		missingSessionAttrib = request.getHeader("currentUser") == null;
		missingSessionAttrib = request.getHeader("sessionId") == null || missingSessionAttrib;
		missingSessionAttrib = request.getHeader("compnayTenantId") == null || missingSessionAttrib;
		return missingSessionAttrib;
	}

	private UserSessionDto getUserSession(HttpServletRequest request) {
		return new UserSessionDto(request.getHeader("sessionId"), Integer.parseInt(request.getHeader("currentUser")),
				request.getHeader("compnayTenantId"));
	}

}
