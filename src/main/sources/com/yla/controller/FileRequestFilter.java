package com.yla.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Clock;

/**
 * Created by Yusuf on 17/12/2016.
 */
public class FileRequestFilter implements Filter {


    private static final String RESOURCE_PATH = "/jsp/";
    private Logger logger = Logger.getLogger(FileRequestFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getServletPath();
        logger.warn("path is " + path);
        //path is /upload.do10:50:49.250
        //if (path.toLowerCase().contains("do")) {

        logLoginUser(request);
        filterChain.doFilter(servletRequest, servletResponse);
        //  } else {
        //    filterChain.doFilter(servletRequest, servletResponse);
        //}

    }

    @Override
    public void destroy() {

    }

    private void logLoginUser(HttpServletRequest request) {
        String remoteUser = request.getRemoteUser();
        String country = request.getLocale().getCountry();
        String remoteHost = request.getRemoteHost();
        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();
        logger.warn("  Logger Name: " + logger.getName());
        logger.warn("  remoteUser: " + remoteUser);
        logger.warn("  country:  " + country);
        logger.warn("  remoteHost: " + remoteHost);
        logger.warn("  requestURI: " + requestURI);
        logger.warn("  remoteAddr: " + remoteAddr);
        logger.warn("  Client Ip is " + getClientIpAddress(request));

    }

    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"};

    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
}
