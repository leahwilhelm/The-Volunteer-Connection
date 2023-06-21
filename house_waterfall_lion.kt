fun main(args: Array<String>) {
 
 //Welcome
 println("Welcome to The Volunteer Connection")
 
 //Variable Declarations
 var userName : String
 var userAge : Int
 var userRole : String
 
 //Get User Information
 println("Please enter your name:")
 userName = readLine()!!
 println("Please enter your age:")
 userAge = readLine()!!.toInt()
 
 //Determine User Role
 when (userAge) {
     in 0..10 -> userRole = "Youth Volunteer"
     in 11..15 -> userRole = "Junior Volunteer"
     in 16..19 -> userRole = "Senior Volunteer"
     else -> userRole = "Adult Volunteer"
 }
 
 //Display Role to User
 println("Welcome $userName! Based on your age ($userAge), you have been assigned as a $userRole")
 
 //Create Volunteer Object
 val volunteerObject = Volunteer(userName, userAge, userRole)
 
 //Display Object Information
 println("\nObject Information\n" +
         "---------------------")
 println("Name: ${volunteerObject.name}\n" +
         "Age: ${volunteerObject.age}\n" +
         "Role: ${volunteerObject.role}\n")
 
 //Declare Tasks Array
 val tasks = arrayOf("Greet visitors", "Organize materials", "Provide assistance")
 
 //Display Tasks to User
 println("Here are some tasks you can help with:\n")
 tasks.forEachIndexed { index, value -> 
     println("${index + 1}. $value")
 }
 
 //Get Selected Task
 println("\nPlease select one of the tasks above to complete:")
 var selectedTask = readLine()!!.toInt()
 
 //Confirm User Selection
 println("\nYou have selected task #$selectedTask. Is this correct? (y/n)")
 var confirmTask = readLine()!!
 
 //Validate User Selection
 if (confirmTask.equals("y", ignoreCase = true)) {
     println("\nCongratulations $userName! You have been assigned to the task: ${tasks[selectedTask - 1]}")
 } else {
     println("\nPlease select the task you wish to complete.")
 }
 
 //Declare User Object Array
 var volunteers : Array<Volunteer> = emptyArray<Volunteer>()
 
 //Add Volunteer Object To Array
 volunteers += volunteerObject
 
 //Loop Through Array and Display Information
 println("\nVolunteer List\n" +
         "---------------------")
 for (volunteer in volunteers) {
     println("Name: ${volunteer.name}\n" +
             "Age: ${volunteer.age}\n" +
             "Role: ${volunteer.role}\n")
 }
 
 //Create Class
 class Volunteer(val name : String, val age : Int, val role : String)
 
 //Thank User
 println("\nThank you for volunteering at The Volunteer Connection, $userName!")
 
}