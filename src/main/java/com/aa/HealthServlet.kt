package com.aa

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/health")
class HealthServlet: HttpServlet()  {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.status = 200
    }
}