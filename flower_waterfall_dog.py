#The Volunteer Connection 

#Python File
import os
import datetime

#Create the main class
class VolunteerConnection():
    #Define class variables 
    directory = os.getcwd()+'/volunteers'
    volunteers = {}
    
    #Constructor 
    def __init__(self):
        if not os.path.exists(self.directory):
            os.makedirs(self.directory)
        self.refresh()

    #Read files and store as dictionary 
    def refresh(self):
        self.volunteers = {}
        for filename in os.listdir(self.directory):
            fh = open(self.directory + '/' + filename, 'r')
            data = fh.read()
            fh.close()
            volunteer = eval(data)
            self.volunteers[volunteer['name']] = volunteer
    
    #Add volunteers 
    def add_volunteer(self, name, address, age, skills):
        #Create dictionary 
        volunteer = {
            'name': name, 
            'address': address, 
            'age': age, 
            'skills': skills 
            }
        #Create filename 
        filename = self.directory + '/' + name + '_' + datetime.datetime.now().strftime('%Y_%M_%d_%H_%M_%S') + '.txt'

        #Write the volunteer info to a file 
        fh = open(filename, 'w')
        fh.write(str(volunteer))
        fh.close()

        #Add to dictionary 
        self.volunteers[name] = volunteer 
    
    #Find volunteers by skill 
    def find_volunteer_by_skill(self, skill):
        volunteers = []
        for name, volunteer in self.volunteers.items():
            if skill in volunteer['skills']:
                volunteers.append(volunteer)
        return volunteers

    #Find volunteers by age
    def find_volunteer_by_age(self, min_age, max_age):
        volunteers = []
        for name, volunteer in self.volunteers.items():
            if volunteer['age'] >= min_age and volunteer['age'] <= max_age:
                volunteers.append(volunteer)
        return volunteers

#Create the main driver
if __name__ == '__main__':
    #Create the connection 
    connection = VolunteerConnection()
    
    #Add volunteers 
    connection.add_volunteer('John Smith', '123 Main St', 25, ['teaching', 'tutoring'])
    connection.add_volunteer('Jane Doe', '456 Elm St', 22, ['mentoring', 'tutoring'])
    connection.add_volunteer('Sally Jones', '789 Oak St', 28, ['counseling', 'mentoring'])

    #Find volunteers by skill 
    volunteers = connection.find_volunteer_by_skill('tutoring')
    for volunteer in volunteers:
        print(volunteer)
    
    #Find volunteers by age
    volunteers = connection.find_volunteer_by_age(25, 35)
    for volunteer in volunteers:
        print(volunteer)