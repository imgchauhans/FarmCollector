# FarmCollector

The app will start running at <http://localhost:8080>.
This API has internaly H2 databse setup and starts automatically when the application started

## Explore Rest APIs

The app defines following APIs.

# POST /farms
 This endpoint creates the entry in H2 DB  to each farm and their crop related data.
   
First execute this API endpoint to create the Farm data into Spring H2 internal database.
   
   Sample Request 1:
    {
    "farmName":"MyFarm",
    "plantedArea":300,
    "cropType":"corn",
    "expectedProduce":40,
    "season":"summer",
    "harvestedProduce": 20
   }
   

Sample Request 2:

{
    "farmName":"MyFarm",
    "plantedArea":300,
    "cropType":"potato",
    "expectedProduce":40,
    "season":"winter",
    "harvestedProduce": 20 }
    
Sample Request 3:

{
    "farmName":"MyFarm2",
    "plantedArea":400,
    "cropType":"potato",
    "expectedProduce":60,
    "season":"winter",
    "harvestedProduce": 40 }
    
Sample Request 4:

{
    "farmName":"MyFarm2",
    "plantedArea":300,
    "cropType":"corn",
    "expectedProduce":30,
    "season":"summer",
    "harvestedProduce": 20 }
    
# GET /farms/{farmName}/planted-crops

This API endpoint returns only planted crops data (not harvested produce) based on each farm and returns data for all seasons 

farmName: This is path Variable , After executing POST API emdpoint, app must have data stored for each farm i.e. MyFarm and MyFarm2.

Please execute this API like this : GET /farms/MyFarm2/planted-crops

Sample response:
[
    {
        "farmName":"MyFarm2",
        "plantedArea":400,
        "cropType":"potato",
        "expectedProduce":60,
         "season":"winter",
    },
    {
       "farmName":"MyFarm2",
    "plantedArea":300,
    "cropType":"corn",
    "expectedProduce":30,
    "season":"summer",
     }
]


# GET /farms/{farmName}/harvested-crops

This API endpoint returns only harvested crops data (not expected produce) based on each farm and returns data for all seasons 

farmName: This is path Variable , After executing POST API endpoint, app must have data stored for each farm i.e. MyFarm and MyFarm2.

Please execute this API like this : GET /farms/MyFarm2/harvested-crops

Sample response:

[
    {
        "farmName":"MyFarm2",
        "plantedArea":400,
        "cropType":"potato",
         "harvestedProduce": 40,
         "season":"winter",
    },
    {
       "farmName":"MyFarm2",
    "plantedArea":300,
    "cropType":"corn",
    "harvestedProduce": 20,
    "season":"summer",
     }
]

   
# GET /farms/{season}

This API endpoint would give you report of planted vs harvested report for all farm and each types of crops

{season}: Thsi is the path variable where you can give the season name which you should give while inserting the data via POST method.


API endpoint would look like; GET /farms/winter

Sample response:

[
    {
        "id": 2,
        "farmName": "MyFarm",
        "plantedArea": 300.0,
        "cropType": "potato",
        "expectedProduce": 40.0,
        "harvestedProduce": 20.0,
        "season": "winter"
    },
    {
        "id": 3,
        "farmName": "MyFarm2",
        "plantedArea": 400.0,
        "cropType": "potato",
        "expectedProduce": 60.0,
        "harvestedProduce": 40.0,
        "season": "winter"
    }
]



