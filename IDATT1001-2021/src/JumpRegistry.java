import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class describing a Registry for long jumps, in an ArrayList
 * @version 1.0
 * @since 16.12.2021
 * @author 10113
 */
public class JumpRegistry {
    private final ArrayList<LongJumpResult> REGISTRYOFJUMPRESULTS;

    /**
     * Constructor for this class, creates an empty arraylist
     * Reasoning:
     * The reason why an arraylist is used is because of its versatility and numerous methods
     * Also this is the list-type I personally have worked the most with
     *
     */
    public JumpRegistry() {
        this.REGISTRYOFJUMPRESULTS = new ArrayList<>();
    }

    /**
     * Register method that takes in all parameters needed for a jump
     * @param startNum, these params are specified in the LongJumpResult-class, see that doc
     * @param name
     * @param result
     * @param faul
     * @param time
     */
    public void registerAJump(int startNum, String name, double result,
                                 boolean faul, String time){
        LongJumpResult inpJump = new LongJumpResult(startNum,name,result,faul,time);
        this.REGISTRYOFJUMPRESULTS.add(inpJump);
    }

    /**
     * A deep copier-method that is later used in the sort-method
     * private for high cohesion
     * @return deepCopied arraylist of jump results
     */
    private ArrayList<LongJumpResult> deepCopier(){
        ArrayList<LongJumpResult> returnArray = new ArrayList<>();
        for(LongJumpResult elm:
             this.REGISTRYOFJUMPRESULTS) {
            returnArray.add(new LongJumpResult(elm));
        }
        return returnArray;
    }

    /**
     * A sorting method that uses the deepCopier and returns a sorted list
     * Private for high cohesion
     * @return deepCopied arraylist which is sorted on the basis of the jump results,
     * also removes fasle jumps
     */
    private ArrayList<LongJumpResult> sortedList(){
        ArrayList<LongJumpResult> returnSortArray = this.deepCopier();
        returnSortArray.sort(Comparator.comparing(LongJumpResult::getResult));
        returnSortArray.removeIf(elm -> !elm.isFaul());
        return returnSortArray;
    }

    /**
     * Uses the sorted list to find the first element of the list, which is the
     * element at the last index-position in the sorted list
     * @return result which is the best registered
     */
    public LongJumpResult returnBestJump(){
        return this.sortedList().get(sortedList().size()-1);
    }

    /**
     * Method that searches for a given name and returns an array with all of that names' jumps
     * @param searchName, is a string
     * @return Arraylist of a searched for persons' jumps
     */
    public ArrayList<LongJumpResult> searchForName(String searchName){
        ArrayList<LongJumpResult> iterArray= this.deepCopier();
        iterArray.removeIf(elm -> !elm.getNAMEOFATHLETE().equalsIgnoreCase(searchName));
        return iterArray;
    }

    /**
     * Method that returns the avg jumpLengt of all verified jumps
     * @return double avg
     */
    public double returnAvgJumpLength(){
        double returnD = 0;
        for(LongJumpResult elm:
        this.deepCopier()){
            if(elm.isFaul()){
                returnD += elm.getResult();
            }
        }
        return returnD/this.sortedList().size();
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("RESULTS OL[W]-2020: \n");
        for(LongJumpResult elm:
        this.deepCopier()){
            returnSB.append(elm);
        }
        return returnSB.toString();
    }
}
