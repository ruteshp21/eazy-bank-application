CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `accounts` (
  `customer_id` int NOT NULL,
  `account_number` int AUTO_INCREMENT  PRIMARY KEY,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `messages` (
  `message_id` int AUTO_INCREMENT  PRIMARY KEY,
  `message_type` varchar(1) NOT NULL,
  `message_local` varchar(5) NOT NULL,
  `message_code` varchar(50) NOT NULL,
  `message_text` varchar(500) NOT NULL
);