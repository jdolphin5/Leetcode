class Solution {
    public class IdRating {
        int id;
        int rating;

        public IdRating(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ret = new ArrayList<>();
        List<IdRating> idRatingList = new ArrayList<>();
        
        for (int i = 0; i < restaurants.length; i++) {
            int restId = restaurants[i][0];
            int restRating = restaurants[i][1];
            int restVegan = restaurants[i][2];
            int restPrice = restaurants[i][3];
            int restDistance = restaurants[i][4];
        
            if ((veganFriendly == 1 && restVegan == 1) || veganFriendly == 0) {
                if (restPrice <= maxPrice && restDistance <= maxDistance) {
                    idRatingList.add(new IdRating(restId, restRating));
                }
            }
        }

        Collections.sort(idRatingList, (a, b) -> a.rating == b.rating ? b.id - a.id : b.rating - a.rating);

        for (IdRating idRating : idRatingList) {
            ret.add(idRating.id);
        }

        return ret;
    }
}