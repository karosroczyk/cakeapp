-- Create a new user
CREATE USER 'cakeapp'@'localhost' IDENTIFIED BY 'cakeapp';

-- Grant privileges to the new user (example: grant all privileges on a specific database)
GRANT ALL PRIVILEGES ON database_name.* TO 'cakeapp'@'localhost';

-- Apply the changes
FLUSH PRIVILEGES;