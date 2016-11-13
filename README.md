# CBT Software

CSE 390 Java Programming: Lab Project

## Introduction

A CBT (Computer Based Testing) software is used to test the capabilities of students using multiple choice (single answer), multiple choice (more than one answer), true or false and fill-in-the blanks type of questions.

## Desired Features

The proposed system should provide students to:

- Login to the system

- Appear for the exam. The questions may be any of the above types
- Display time remaining during the exam
- Show the marks scored by the students after the end of exam
- Exit from the system.

Though some of the features listed below are necessary for the system to function properly,like:

- faculty should be able to add user name, password for the user
- set number of questions
- marks for each question
- time duration etc
- But for these feature sets, no user interface is required, but there should be some feature (say reading from a file) present.

## Prerequisites

```
$ sudo apt-get install postgresql pgadmin3
```

## Clone the repo

Change directory to the localhost folder
```
$ https://github.com/Chirath02/CBTSoftware.git
```

## PgAdmin3

Modify password for role postgres:
```
$ sudo -u postgres psql postgres
$ alter user postgres with password 'postgres';
```
Now connect to pgadmin using username postgres and password postgres

## DDL commands to create Tables

```
$ sudo -u postgres -i
$ psql
```

copy paste and execute all the commands in sqldll.sql file.
