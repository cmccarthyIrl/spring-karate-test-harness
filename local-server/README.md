| **Step** | **Description** | **Endpoint** |
| --- | --- | --- |
| 1 | Retrieve a  LIST of heros | [http://localhost:8080/hero](http://localhost:8080/hero) |
| 2 | Update the details for your hero | [http://localhost:8080/hero/{id}](http://localhost:8080/hero/%7Bid%7D) |
| 3 | Create a battle between your heros. From the battle results respone retrieve the battleID |[http://localhost:8080/battle](http://localhost:8080/battle) 
| 4 | Use the battleID to query the Results Endpoint to retrieve your battle result | [http://localhost:8080/result](http://localhost:8080/result) |