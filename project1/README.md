# Project 1 - iVote Simulator

Simulation for a live poll of students answering a question.  

## Project specifications

The simulation automates the creation of a question which students answer.  
The question can have one or more correct answers. Students can be allowed to choose one, or multiple answers.  
Each student has a unique ID associated with their answer. A student's latest submission counts as their submission.  
After the submissions close, the statistics are posted.  

## Project implementation

### App
The simulation is ran by the main class, App. App starts the simulation by creating a random instance of a question.  
App generates a random amount of students in a StudentArray, and calls Student::answerQuestion for each student.  
App passes the StudentArray to VotingService, which outputs the result of the simulation.  

### Question
A question has a boolean multiple which states whether multiple answers can be selected or not.  
A question has a boolean array of answers, with the boolean representing if the answer is correct or not.  
Questions are 0-indexed corresponding to the array. Each index will be represented alphabetically in output, with 0=A, 1=B, etc.  
The length of the array represents how many answers the question has.  

### Student
A student has a question which it uses to answer it. All students in the simulation have the same question.  
A student has an integer array of selected answers corresponding to the indices of the question array, which is populated in answerQuestion().  
A student has a unique ID string which identifies the student. In the case the student submits multiple times, only the latest submission is counted.  
A student has a boolean isSmart which influences how likely the student is to pick one or more of the correct answers.  
A student has a function answerQuestion() which answers the question based on the question's parameters.  

### VotingService
VotingService has a static function outputResults() which inputs an array of students and outputs the results of the simulation.  