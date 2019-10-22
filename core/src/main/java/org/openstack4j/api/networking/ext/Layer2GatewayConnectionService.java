package org.openstack4j.api.networking.ext;

import org.openstack4j.common.RestService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.Layer2GatewayConnection;

import java.util.List;

public interface Layer2GatewayConnectionService extends RestService {

    /**
     * Lists all Layer2GatewayConnections authorized by the current Tenant
     *
     * @return the list of Layer2GatewayConnections
     */
    List<? extends Layer2GatewayConnection> list();

    /**
     * Gets the Layer2GatewayConnection by ID
     *
     * @param gatewayConnectionId the gateway connection identifier
     * @return the Layer2GatewayConnection or null if not found
     */
    Layer2GatewayConnection get(String gatewayConnectionId);

    /**
     * Delete a Layer2GatewayConnection by ID
     *
     * @param gatewayConnectionId the gateway connection identifier to delete
     * @return the action response
     */
    ActionResponse delete(String gatewayConnectionId);

    /**
     * Creates a new Layer2GatewayConnection
     * @param gateway the Layer2GatewayConnection to create
     * @return the newly created Layer2GatewayConnection
     */
    Layer2GatewayConnection create(Layer2GatewayConnection gateway);

    /**
     * Updates an existing Layer2GatewayConnection.  The Layer2GatewayConnection identifier must be set on the gateway object to be successful
     * @param gateway the Layer2GatewayConnection to update
     * @return the updated Layer2GatewayConnection
     */
    Layer2GatewayConnection update(Layer2GatewayConnection gateway);
}
