# Java Email Client Application

## Overview

The Java Email Client is a command-line-based application designed to simplify email management while incorporating key Object-Oriented Programming (OOP) concepts. This application offers features such as recipient categorization, automated birthday greetings, and efficient command-line messaging.

## Key Features

#### Recipient Details Management

* Efficiently store and manage recipient details for everyday email communication.
* Categorize recipients into three distinct categories: "Officials," "Official Friends," and 	 
  "Personal Friends."
* Save recipient details in specific formats based on their category:
              Officials: <name>, <email>, <designation>
              Official Friends: <name>, <email>, <designation>, <birthday>
              Personal Friends: <name>, <nick-name>, <email>, <birthday>
			  
#### Automated Birthday Greetings

* Automatically checks for recipients with birthdays on the current day.
* Sends personalized birthday greetings to recipients based on their assigned category.
  
#### Command-Line Messaging

* Send messages directly from the command line to any provided email address.
  
#### Email History Retrieval

* Retrieve information about all emails sent on a specific day.
  
#### Persistent Storage

* Store all sent emails on the local hard disk as serialized objects, ensuring efficient data persistence.
* Utilizes object serialization and deserialization concepts for data storage and retrieval.
  
### Requirements

* JavaMail API: This application uses the JavaMail API for email-sending operations.
  
### Project Components

* User Interface: "EClient.java" serves as the user interface for the application, allowing 
  users to interact with the email client.
* Java Mail Implementation: "SendEmails.java" handles the sending of emails.
* Object Serialization and Deserialization: "Serialize_Deserialize.java" is responsible for efficient 
  storage and retrieval of email data using object serialization and deserialization.
  
### Prerequisites

* Familiarity with Object-Oriented Programming Concepts.
* Understanding of Object Serialization and Deserialization.
  
### General Constraints

* To send emails using the application, you must provide a valid sender email ID and its corresponding password within the "SendEmails.java" file. This information is required for authentication with the email server.
* To generate an application-specific password, please follow the instructions provided by your email service provider. For example, instructions for generating a Gmail application-specific password can be found at https://support.google.com/mail/answer/185833?hl=en.





