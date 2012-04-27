# J2EE Sample

This is a sample war application using the following technologies:
 * JSF - for view
 * CDI - for dependency injection
 * JPA 2.0 - for persistence
 * EJB 3.1 - for services
 * Arquillian - for integration testing
 * JBoss Application Server 7

There are two maven profiles for testing the application:
 * arq-jbossas-7-managed - which downloads a version of the JBoss AS and uses it
 * arq-jbossas-7-remote - which uses an already started JBoss AS