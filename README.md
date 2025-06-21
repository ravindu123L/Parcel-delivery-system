# Parcel-delivery-system
parcel delivery system create by using java


📌 Project Description:
-------------------------------
This project simulates an intelligent parcel delivery system that assigns delivery vehicles to customer locations based on:
- Parcel priority
- Delivery deadlines
- Road travel times

✅ Core Data Structures (Manually Implemented):
-----------------------------------------------
1. Max Heap      - Prioritizes parcel requests
2. Graph         - Represents city zones and roads
3. Dijkstra's    - Finds shortest path for delivery
4. List/ArrayList - Vehicle tracking system

📁 Files Included:
-------------------
- Main.java             → Main simulation program
- Parcel.java           → Represents parcel requests
- Vehicle.java          → Represents delivery vehicles
- MaxHeap.java          → Custom max heap for parcels
- Graph.java            → Graph with Dijkstra algorithm
- VehicleManager.java   → Vehicle allocation system
- SampleData.java       → Sample parcel, vehicle, and map data

📋 How to Compile and Run:
---------------------------
Open Terminal / CMD in project folder and type:

1. Compile all files:
   javac *.java

2. Run the simulation:
   java Main

Expected Output: Parcel assignment details with vehicle IDs, delivery zones, and delivery success/failure based on deadline.

📚 Note:
--------
- No external libraries are used.
- Code is beginner-friendly and well-commented.

==============================
