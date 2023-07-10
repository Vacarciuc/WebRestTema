# time_zone_rest
Application for determining the current time depending on the city.
the continent, city and time zone are stored in the XML file.
The application knows how to read the time zone from XML, after which it converts it into hours, minutes and seconds.
To be able to parse the XML document, please change the path to the ParserSTAX.java class file.
To be able to view the time, please enter the following address as an example http://localhost:8080/RESTful/AddService/Europe/Amsterdam.
Available continents and cities:
 Europe ->Amsterdam
	      ->Andorra
	      ->Astrakhan
	      ->Belgrade
	      ->Bucharest

 Asia   ->Vietnam
	      ->Kuwait
	      ->Dubai

In case the data is entered incorrectly or the address does not exist, the corresponding message is displayed.
