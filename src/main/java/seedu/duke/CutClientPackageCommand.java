package seedu.duke;

public class CutClientPackageCommand extends Command {
    private final String clientPackageId;
    private ClientPackage clientPackage;

    /**
     * Class constructor for CutCommand.
     *
     * @param clientPackageId ID of to-be-deleted clientPackage in the clientPackage list
     */
    public CutClientPackageCommand(String clientPackageId) {
        this.clientPackageId = clientPackageId;
    }

    /**
     * Executes the deletion of a specific clientPackage from clientPackage list, according to the clientPackageId.
     */
    @Override
    public void execute() {
        try {
            this.clientPackage = clientPackages.getClientPackageById(clientPackageId);
            int newClientPackageCount = clientPackages.getClientPackageCount() - 1;
            ui.showCut(clientPackage);
            clientPackages.cut(clientPackage);
            assert newClientPackageCount == clientPackages.getClientPackageCount();
            assert newClientPackageCount >= 0;
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("INVALID: Index out of bounds");
        } catch (TourPlannerException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
