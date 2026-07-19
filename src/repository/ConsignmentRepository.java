package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Consignment;

public class ConsignmentRepository {

  private final Map<Long, Consignment> consignments;

  public ConsignmentRepository() {

    consignments = new HashMap<>();

  }

  public void addConsignment(Consignment consignment) {

    consignments.put(
        consignment.getId(),
        consignment);

  }

  public Consignment getConsignment(long consignmentId) {

    return consignments.get(consignmentId);

  }

  public Collection<Consignment> getAllConsignments() {

    return consignments.values();

  }

}