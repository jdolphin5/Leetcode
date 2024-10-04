class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int skillNum = skill[0] + skill[skill.length - 1];
        long ret = 0;

        for (int i = 0; i < skill.length / 2; i++) {
            int last = skill[skill.length - 1 - i];
            int first = skill[i];

            if (last + first != skillNum)
                return -1;

            long prod = 1L * last * first;
            ret += prod;
        }

        return ret;
    }
}