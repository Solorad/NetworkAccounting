DROP DATABASE IF EXISTS NETWORK;

CREATE DATABASE  NETWORK DEFAULT CHARACTER SET cp1251
  DEFAULT COLLATE cp1251_general_ci;
USE NETWORK;

CREATE TABLE IF NOT EXISTS NODE (
  node_id INT UNSIGNED  NOT NULL AUTO_INCREMENT,
  node_name VARCHAR(100) NULL,
  node_region VARCHAR(100) NULL,
  node_street VARCHAR(100) NULL,
  node_address  VARCHAR(100) NULL,
  PRIMARY KEY (node_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS CONNECTOR (
  connector_id INT UNSIGNED  NOT NULL AUTO_INCREMENT,
  connector_name VARCHAR(100) NULL,
  connector_capacity INT DEFAULT 0,
  connector_node_id INT UNSIGNED,
  INDEX node_ind (connector_node_id),
  FOREIGN KEY (connector_node_id)
  REFERENCES NODE(node_id)
    ON DELETE CASCADE,
  PRIMARY KEY (connector_id)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS POINT (
  point_connector_id INT UNSIGNED  NOT NULL,
  point_num INT UNSIGNED NOT NULL,
  INDEX connector_ind (point_connector_id),
  FOREIGN KEY (point_connector_id)
  REFERENCES CONNECTOR(connector_id)
    ON DELETE CASCADE,
  PRIMARY KEY (point_connector_id, point_num)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS LINK (
  left_point_connector_id INT UNSIGNED  NOT NULL,
  left_point_num INT UNSIGNED NOT NULL,
  right_point_connector_id INT UNSIGNED  NOT NULL,
  right_point_num INT UNSIGNED NOT NULL,
  FOREIGN KEY (left_point_connector_id)
  REFERENCES CONNECTOR(connector_id),
  FOREIGN KEY (right_point_connector_id)
  REFERENCES CONNECTOR(connector_id),
  PRIMARY KEY (left_point_num, left_point_connector_id, right_point_num, right_point_connector_id)
) ENGINE=INNODB;