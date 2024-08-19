# Farmers Market Web Application

## Overview

This project is a Spring Boot web application for managing and displaying farmers market information.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven
- MySQL database

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/your-repo/farmers-market-web.git
    cd farmers-market-web
    ```

2. Configure the database:
    - Update the `src/main/resources/application.properties` file with your MySQL database credentials.

3. Generate the necessary tables:
    - The application will automatically generate the required tables when it starts.

## Scripts

### Running the Application

To run the application, use the `run.sh` script located in the `scripts` folder:

```sh
./scripts/run.sh