
module coldstart.piranha.embedded {

    exports coldstart.piranha.embedded;
    requires cloud.piranha.http.api;
    requires cloud.piranha.http.impl;
    requires cloud.piranha.http.webapp;
    requires cloud.piranha.embedded;
    requires jakarta.servlet;
}
