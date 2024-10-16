const students = [];

function addStudents() {
    const numberOfStudents = parseInt(prompt("How many students would you like to add?"));
    
    if (!isNaN(numberOfStudents) && numberOfStudents > 0) {
        for (let i = 0; i < numberOfStudents; i++) {
            const name = prompt(`Enter the name of student ${i + 1}:`);
            const age = parseInt(prompt(`Enter the age of student ${i + 1}:`));
            const grade = parseInt(prompt(`Enter the grade of student ${i + 1} :`));

            // Ensure the age and grade inputs are valid
            if (!name || isNaN(age) || age <= 0 || isNaN(grade) ) {
                alert('Invalid input. Please enter valid details.');
                i--;  // Prompt again for the same student in case of invalid input
            } else {
                students.push({ name, age, grade });
            }
        }
        alert('All students added successfully!');
    } else {
        alert('Please enter a valid number of students.');
    }
}


function viewStudents() {
    const studentTableBody = document.getElementById('studentTableBody');
    const studentTable = document.getElementById('studentTable');
    studentTableBody.innerHTML = '';  // Clear existing table rows

    if (students.length === 0) {
        alert('No students added yet.');
        studentTable.style.display = 'none';  // Hide the table if no students
        return;
    }

    // Populate the table with student data
    students.forEach(student => {
        const row = document.createElement('tr');
        const nameCell = document.createElement('td');
        const ageCell = document.createElement('td');
        const gradeCell = document.createElement('td');

        nameCell.textContent = student.name;
        ageCell.textContent = student.age;
        gradeCell.textContent = student.grade;

        row.appendChild(nameCell);
        row.appendChild(ageCell);
        row.appendChild(gradeCell);
        studentTableBody.appendChild(row);

        row.addEventListener('mouseover', () => {
            row.style.backgroundColor = ' #0096FF';  // Change color on hover
        });

        // Add mouseout event listener to reset background color
        row.addEventListener('mouseout', () => {
            row.style.backgroundColor = '';  // Reset color when not hovered
        });
    });

    
    studentTable.style.display = 'table';  // Show the table when students are available
}

function sortStudents() {
    // Sorting students by age in descending order
    students.sort((a, b) => b.age - a.age);
    alert('Students sorted by age in descending order!');
    viewStudents();  // To refresh the displayed student list after sorting
}

function initDeleteStudent() {
    // Show the delete section for typing a name
    document.getElementById('deleteSection').style.display = 'block';
    document.getElementById('deleteStudentName').value = '';  // Clear input field
    document.getElementById('studentSuggestions').style.display = 'none';  // Hide suggestions initially
}

// Function to filter students as the user types in the delete input field
function filterStudents() {
    const nameInput = document.getElementById('deleteStudentName').value.toLowerCase();
    const suggestionList = document.getElementById('studentSuggestions');
    suggestionList.innerHTML = '';  // Clear previous suggestions

    if (nameInput === '') {
        suggestionList.style.display = 'none';
        return;
    }

    const matchingStudents = students.filter(student => student.name.toLowerCase().startsWith(nameInput));

    if (matchingStudents.length === 0) {
        suggestionList.style.display = 'none';
    } else {
        suggestionList.style.display = 'block';  // Show suggestions
        matchingStudents.forEach(student => {
            const li = document.createElement('li');
            li.textContent = `${student.name} (Grade: ${student.grade})`;

            // Add event listener to select the student for deletion
            li.addEventListener('click', () => {
                confirmDeleteStudent(student);
            });

            suggestionList.appendChild(li);
        });
    }
}

// Function to confirm and delete the selected student
function confirmDeleteStudent(student) {
    const confirmDelete = confirm(`Are you sure you want to delete ${student.name} (Grade: ${student.grade})?`);
    if (confirmDelete) {
        const studentIndex = students.findIndex(s => s.name === student.name && s.grade === student.grade);
        if (studentIndex !== -1) {
            students.splice(studentIndex, 1);  // Remove the student from the array
            alert(`${student.name} has been deleted.`);
            viewStudents();  // Refresh the table if it's visible
            document.getElementById('deleteSection').style.display = 'none';  // Hide delete section after deletion
        }
    }
}

function clearInputs() {
    document.getElementById('name').value = '';
    document.getElementById('age').value = '';
    document.getElementById('grade').value = '';
}