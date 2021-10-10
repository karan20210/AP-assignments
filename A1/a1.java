import java.util.*;

class a1
{
    public static void main(String[] args) {
        cowin c = new cowin();
        c.displayMenu();
        
    }

}


// HOW THE PROGRAM WORKS :)

// This file is the main file which makes an object on the class cowin and then displays the menu
// We have 5 classes namely - cowin, vaccine, hospital, citizen and slot
// In the menu we have 7 functions each of which have a function in the file cowin.java

// There are 4 hashmaps namely vaccineMap - maps vaccine name to its object, hospitalMap - maps hospitalId to its object, citizenMap - maps citizen UID to its
// object and slotMap - which maps the hospital Id to an arrayList of all its slots

// The function addVaccine takes in the necessary inputs, creates a new vaccine object and maps it to vaccineMap
// The function addHospital takes in the necessary inputs, creates an new hospital object and maps it to hospitalMap
// The function addCitizen takes in the necessary inputs, checks if the UID is unique, creates an new citizen object and maps it to citizenMap

// addSlot asks for the hospital ID and fetches the required hospital object through the hospitalMap
// It takes the necessary inputs, creates a new slot object, and adds this slot in the required hospital by adding it to the slots arraylist of the hospital 
// and maps that arraylist to the hospitalId

// bookSlot asks for the UID and checks whether the UID exists or not. If yes, it fetches the required citizen object through citizenMap
// If the citizen is fully vaccinated it doesn't allow them to go further. 
// Else they are given the required choices.

// If search by area is chosen then the inputted pincode is compared with the pincodes of all the registered hospitals, and if found equal then the hospital
// is added to an arrayList named availableHospitals. Then the hospital ID is inputted and the corresponding hospital object is fetched. Then we display
// the slots for booking by iterating over the 'slots' arraylist inside the hospital object. After that the slot number is chosen and then we 
// call the getVaccinated() function for the citizen. It firstly gets the vaccine slot from the slot number and hospital. It returns back if there is no suitable slot
// It then checks the citizen's vaccination status and updates the new status and the next due date accordingly. It then reduces the quantity of the 
// vaccine in the chosen slot by 1. It then checks the Slots in the hospital and removes a slot if it has 0 vaccines. 

// Search by vaccine is quite similar. It inputs the reqd vaccine name and then checks whether it is present in an arrayList of all vaccines in all slots of the
// hospital. If it is, it's added to the availableHospital arrayList. The only difference in this implementation is that it does not display the slots
// of other vaccines. 

// displayHospitalSlot takes the hospital ID, fetches the corresponding hospital object, and then iterates over the slot arrayList

// Get vaccination details get the citizen object through the UID, and displays the information