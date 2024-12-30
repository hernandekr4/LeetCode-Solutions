package Medium;

public class Challenge134_GasStation {
    public static void main(String[] args) {
        GasStation solution = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost)); // Output: 3
    }
}


class GasStation{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int total =0;
        int tank =0;
        int start =0;

        for(int i =0; i< gas.length;i++){
            int currentGas = gas[i]-cost[i];
            total += currentGas;
            tank += currentGas;

            if(tank < 0){
                start = i+1;
                tank =0;
            }
        }
        return total >=0? start : -1;


    }
}
