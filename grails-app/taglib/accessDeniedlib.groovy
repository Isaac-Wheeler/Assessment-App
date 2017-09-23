class accessDeniedlib {
    def accessDeniedCustom = {
      response.sendRedirect("${request.contextPath}/") //TODO edit
    }
  }
