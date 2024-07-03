public class Room {
        private int roomNumber;
        private String bedType;
        private String roomType;
        private double price;
        private boolean cleaningStatus;
    private boolean updated;

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getBedType() {
            return bedType;
        }

        public void setBedType(String bedType) {
            this.bedType = bedType;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isCleaningStatus() {
            return cleaningStatus;
        }

        public void setCleaningStatus(boolean cleaningStatus) {
            this.cleaningStatus = cleaningStatus;
        }

        public Room(int roomNumber, String roomType, String bedType, double price, boolean cleaningStatus){
            this.roomNumber= roomNumber;
            this.roomType= roomType;
            this.bedType= bedType;
            this.price= price;
            this.cleaningStatus=cleaningStatus;

         //getter ve setter lar
        }


    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}

