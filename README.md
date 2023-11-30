# kururin_app

OUT OF SERVICE

Kururin is a not working task management system designed to "help?" users organize and track their tasks (not)efficiently.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Creating Tasks](#creating-tasks)
  - [Managing Tasks](#managing-tasks)
- [Advanced Configuration](#advanced-configuration)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Features

- **Task Management:** Create, edit, and organize tasks with due dates, priorities, and categories.
- **User Authentication:** Secure your tasks by associating them with user accounts.
- **Filtering and Sorting:** Easily find tasks based on their state, category, due date, or priority.
- **Email Notifications:** Receive email notifications for otp verifications.

## Getting Started

### Prerequisites

Before running Kururin, ensure you have the following installed:

- [Java](https://www.java.com/) (version 11 or higher)
- [Gradle](https://gradle.org/)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Aveira-jdk/kururin_app.git
    ```

2. Navigate to the project directory:

    ```bash
    cd kururin_app
    ```

3. Build the project using Gradle:

    ```bash
    ./gradlew build
    ```

4. Run the application:

    ```bash
    ./gradlew bootRun
    ```

The Kururin application should now be running locally.

## Usage

### Creating Tasks(not working)

1. Access the Kururin web interface at [http://localhost:8080](http://localhost:8080).
2. Log in with your user account or create a new account.
3. Navigate to the "Tasks" section.
4. Click "New Task" and fill in the details.

### Managing Tasks(not working)

- **Mark as In Progress:** Change the state of a task to "In Progress."
- **Mark as Canceled:** Cancel a task that is no longer relevant.
- **Mark as Done:** Mark a task as completed.

## Advanced Configuration(out of service)

For advanced configuration options, refer to the [JpaConfig](src/main/java/herta/kuru_kuru/kururin/config/JpaConfig.java) class.

## Contributing(not welcomed)

Contributions are welcome! Please follow the [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the *** License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- This project was inspired by the need(demands of my teacher) for a flexible and efficient task management system(idk why).
