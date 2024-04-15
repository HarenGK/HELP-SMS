# HELP School Management System (HELP-SMS)

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Overview

This project is a School Management System (SMS) developed in Java, designed to streamline and automate various administrative and academic tasks within an educational institution.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Project Authors](#authors)

## Authors

- **Harenthirah Gopala Krishnan**
  - GitHub: [@HarenGK](https://github.com/HarenGK)
  - LinkedIn: [Harenthirah Gopala Krishnan](https://www.linkedin.com/in/harengk/)
 
- **Ryan Siew Zhu-Ruong**
  - GitHub: [@Rogue7929](https://github.com/Rogue7929)

- **Wong Cheng Yong**
  - GitHub: [@WCYG22](https://github.com/WCYG22)
  - LinkedIn: [Wong Cheng Yong](https://www.linkedin.com/in/wong-cheng-yong/)


## Features

1. **Enrollment and Registration:**
   -  Facilitates enrollment and registration processes for students, managing class assignments, and academic schedules. Supports both Full-time and Part-time students.

2. **Attendance Tracking:**
   - Automates recording and tracking of student attendance, making it easier for teachers and administrators to monitor and manage.

3. **Course Management:**
   - Manages information related to courses offered, including schedules and teacher assignments.

4. **Teacher Information Management:**
   - Maintains records of teachers, including qualifications, contact details, and assigned courses.

6. **Grading and Assessment:**
   -  Automates the grading process, allowing teachers to input grades for assessments. Generates transcripts and grade reports for students.


## Classes and Structures

1. **School:**
   Represents the educational institution and manages students, teachers, and courses.
2. **Student:**
   Base class for Part Time and Full Time Student, representing student's information and managing enrolled courses.
3. **Part-time Student:**
   Inherits Students, contains Employment Status Information and Maximum Credit Hours information.
4. **Full-time Student:**
   Inherits Students, contains Scholarship Amount Value and Minimum Credit Hours information.
5. **Teacher:**
   Represents teacher's information and managing assigned courses.
6. **Course:** 
   Represents courses offered by the school and manages enrolled students and assigned teachers.


## Classes and Structures

To get started with the School Management System, follow these steps:

1. Clone the repository to your local machine:
_git clone https://github.com/your_username/school-management-system.git_
2. Open the project (under src) in your preferred Java IDE.
3. Compile and run Main.Java to start using the School Management System.
