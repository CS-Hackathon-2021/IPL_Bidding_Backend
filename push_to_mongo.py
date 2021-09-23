import pandas as pd

def get_database():
    from pymongo import MongoClient
    import pymongo

    # Provide the mongodb atlas url to connect python to mongodb using pymongo
    CONNECTION_STRING = "mongodb://18.116.170.33:27017"

    # Create a connection using MongoClient. You can import MongoClient or use pymongo.MongoClient
    from pymongo import MongoClient
    client = MongoClient(CONNECTION_STRING)

    # Create the database for our example (we will use the same database throughout the tutorial
    return client['hackathon']
    
# This is added so that many files can reuse the function get_database()
if __name__ == "__main__":    
    
    # Get the database
    dbname = get_database()
    print(dbname)
    player=dbname["player"]
    item_details = player.find()
    df=pd.read_csv("IPL IMB381IPL2013.csv")
    players=[]
    for index,row in df.iterrows():
        
        players.append({
            "name":row["PLAYER NAME"],
            "age":int(row["AGE"]),
            "basePrice":int(row['BASE PRICE']),
            "country":row["COUNTRY"],
            "category":row['PLAYING ROLE'],
            "noOfWickets":int(row["T-WKTS"]),
            "noOfMatches":10,
            "runsScored":int(row["T-RUNS"]),
            "isSold": False,
            "currentBid":0,
            "imageURL":""
        })
    player.insert_many(players)