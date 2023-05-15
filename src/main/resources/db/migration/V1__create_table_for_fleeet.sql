CREATE TABLE Fleet (
  fleet_number SERIAL PRIMARY KEY,
  fleet_Code UUID,
  fleet_Plate VARCHAR(10) NOT NULL,
  fleet_Model VARCHAR(50) NOT NULL,
  fleet_Fuel_Type VARCHAR(20) NOT NULL,
  fleet_Load_Capacity VARCHAR(10) NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  maintenance BOOLEAN DEFAULT FALSE
);


