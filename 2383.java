class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int curExperience = initialExperience;
        int curEnergy = initialEnergy;

        int trainingHours = 0;

        for (int i = 0; i < n; i++) {
            if (energy[i] >= curEnergy) {
                int diff = energy[i] - curEnergy;
                trainingHours += diff + 1;
                curEnergy += diff + 1;
            }
            curEnergy -= energy[i];
        }

        for (int i = 0; i < n; i++) {
            if (experience[i] >= curExperience) {
                int diff = experience[i] - curExperience;
                trainingHours += diff + 1;
                curExperience += diff + 1;
            }
            curExperience += experience[i];
        }

        return trainingHours;
    }
}