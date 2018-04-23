package data.assessment.project

class Teacher {

  //NOTE: DB creates ID for table
  // time stamps: automatically populated by GORM
  Date dateCreated;     //this property holds the date in which the teacher's account was created.
  Date lastUpdated;   //this property holds the date in which the teachers account was last updated

  // properties
  String firstName;   //this property holds the first name of the teacher
  String lastName;    //this property holds the last name of the teacher
  String username;    //this property holds the username that the teacher gave their account
  String password;        // plain text, not stored and this property holds the password that the teacher gave their account
  String confirm;         // plain text, not stored and this property also holds the password that the teacher gave their account but this is used as a check to make sure their password was entered correctly upon creation
  String passwordHashed;    //this property holds the hashed version of the teachers' password
  boolean admin;    //this property marks whether or not the account is an admin or not.
  Document profilePic;    //this propety is essentialy a hasOne relation such that a teacher can have a Document attached their account (a file or more specifically an image) that is used as their profile picture
  boolean urlSignup;    //this proprty marks whether or not there is urlSignup or not.
  Date lastLogin;   //this property holds the date for when the account was last logged in.


  static mapping = {    //this creates the way in which the teachers are created in the DB such that their last names are in ascending order.
      sort lastName: "asc"
  }


  // transients
  static transients = ['password', 'confirm']


    static constraints = {
      firstName blank:false   //this means that the firstName cannot be left as whitespace
      confirm blank:false   //this means that the confirm property cannot be left as whitespace
      lastName  blank:false   //this means that the lastName property cannot be left as whitespace
      profilePic nullable:true    //this means that an account does not have to have a profilePic
      lastLogin nullable:true   //this means that there does not have to be a lastLogin date (this is set for right after creating an account)
      username  blank:false, size:5..15, matches:/[\S]+/, unique:true   //this means that the username cannot be whitespace, it has to be between 5 and 15 characters and that it is unique to any other created usernames in the DB.
      password  blank:false, size:5..15, matches:/[\S]+/, validator:{ val, obj ->   //this means that the password cannot be left as whitespace, it has to be between 5 and 15 characters, and it has to pass the validator such that the password and confirm properties match.
          if (obj.password != obj.confirm)
              return 'teacher.password.dontmatch'
      }
    }

    String toString(){    //this function allows for an easier way to display in the teachers name in the front end.
      return firstName + " " + lastName
    }
}
