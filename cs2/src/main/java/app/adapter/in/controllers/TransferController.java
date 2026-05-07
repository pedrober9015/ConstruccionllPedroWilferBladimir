package app.adapter.in.controllers;

import java.util.ArrayList;

import app.domain.model.BankAccount;
import app.domain.model.Transfer;
import app.domain.model.enums.TransferStatus;

public class TransferController {
    private ArrayList<Transfer> transfers;

    // Constructor
    public TransferController() {
        this.transfers = new ArrayList<>();
    }

    // Create transfer
    public Transfer createTransfer(
            BankAccount sourceAccount,
            BankAccount destinationAccount,
            double amount,
            String currency,
            String description) {

        Transfer transfer = new Transfer(
                sourceAccount,
                destinationAccount,
                amount,
                currency,
                description
        );

        transfers.add(transfer);

        System.out.println("Transfer created successfully.");
        System.out.println("Reference code: " + transfer.getReferenceCode());

        return transfer;
    }

    // Complete transfer
    public void completeTransfer(Transfer transfer) {

        transfer.complete();

        System.out.println("Transfer completed successfully.");
    }

    // Fail transfer
    public void failTransfer(Transfer transfer) {

        transfer.fail();

        System.out.println("Transfer failed.");
    }

    // Cancel transfer
    public void cancelTransfer(Transfer transfer) {

        try {
            transfer.cancel();
            System.out.println("Transfer cancelled successfully.");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Show transfer information
    public void showTransferDetails(Transfer transfer) {

        System.out.println("===== TRANSFER DETAILS =====");
        System.out.println("Transfer ID: " + transfer.getTransferId());
        System.out.println("Reference Code: " + transfer.getReferenceCode());
        System.out.println("Amount: " + transfer.getAmount());
        System.out.println("Currency: " + transfer.getCurrency());
        System.out.println("Status: " + transfer.getStatus());
        System.out.println("Description: " + transfer.getDescription());
        System.out.println("Date: " + transfer.getTransferDate());
    }

    // List all transfers
    public void listTransfers() {

        System.out.println("===== TRANSFER LIST =====");

        for (Transfer transfer : transfers) {
            System.out.println(transfer);
        }
    }

    // Find transfer by reference code
    public Transfer findTransferByReference(String referenceCode) {

        for (Transfer transfer : transfers) {

            if (transfer.getReferenceCode().equals(referenceCode)) {
                return transfer;
            }
        }

        return null;
    }

    // Update transfer status manually
    public void updateTransferStatus(Transfer transfer, TransferStatus status) {

        transfer.setStatus(status);

        System.out.println("Transfer status updated to: " + status);
    }
}
