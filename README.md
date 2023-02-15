# Crosskey-Codetest
A repository containing a codetest

# Hosting
This project is currently hosted on the following address/ip:

- http://16.170.224.156:443/

Contact frans.sontag@hotmail.com should the link not function for some reason

### Value formats when entering numeric data
- Interest% per month: Percentage, not decimal form
- Total loan: loan in euros
- Nr. of years: an integer value for the number of years

# Prerequisites
- Java
- Maven
- Git
- Docker

# Building
To build the project do the following steps via terminal of your choice(commands below the steps, remove parentheses):

1. Navigate to your desired directory
2. Clone the project
3. Navigate inside the created directory if one was made
4. Run the maven build
5. Run the docker image build

```
cd (path to dir)
git clone (url)
cd (path to new dir)
mvn install -Pproduction
docker build --tag=codetest:latest .
```

The project has now been built.

# Running the project
After building the project it can be run via terminal with the following command:
```docker run -p(port to use):8080 codetest:latest```
