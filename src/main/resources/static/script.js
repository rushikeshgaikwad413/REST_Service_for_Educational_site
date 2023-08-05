document.addEventListener("DOMContentLoaded", function() {
    const addStudentForm = document.getElementById("addStudentForm");
    const studentList = document.getElementById("studentList");

    // Function to fetch and display the list of students
    function displayStudentList() {
        fetch("/students")
            .then(response => response.json())
            .then(data => {
                studentList.innerHTML = ""; // Clear previous list
                data.forEach(student => {
                    const listItem = document.createElement("li");
                    listItem.className = "list-group-item d-flex justify-content-between align-items-center";
                    listItem.innerHTML = `
                        ${student.firstName} ${student.lastName} (${student.email})
                        <button class="btn btn-danger btn-sm delete-btn" data-student-id="${student.id}">Delete</button>
                    `;
                    studentList.appendChild(listItem);
                });
            })
            .catch(error => console.error("Error fetching student list:", error));
    }

    // Function to delete a student by ID
    function deleteStudent(studentId) {
        fetch(`/students/${studentId}`, {
            method: "DELETE"
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error(`Failed to delete student with ID ${studentId}`);
            }
        })
        .then(data => {
            console.log("Student deleted:", data);
            displayStudentList(); // Refresh the student list after deletion
        })
        .catch(error => console.error(error));
    }

    // Listen for submit event on the addStudentForm
    addStudentForm.addEventListener("submit", function(event) {
        event.preventDefault();

        // ... (Your existing code to add a student)

        displayStudentList(); // Refresh the student list after adding a student
    });

    // Listen for click events on delete buttons
    studentList.addEventListener("click", function(event) {
        if (event.target.classList.contains("delete-btn")) {
            const studentId = event.target.getAttribute("data-student-id");
            if (confirm("Are you sure you want to delete this student?")) {
                deleteStudent(studentId);
            }
        }
    });

    // Initial display of student list
    displayStudentList();
});
