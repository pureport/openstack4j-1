package org.openstack4j.api.networking.ext;

import org.openstack4j.common.RestService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.Layer2Gateway;

import java.util.List;

public interface Layer2GatewayService extends RestService {

    /**
     * Lists all Layer2Gateways authorized by the current Tenant
     *
     * @return the list of Layer2Gateways
     */
    List<? extends Layer2Gateway> list();

    /**
     * Gets the Layer2Gateway by ID
     *
     * @param gatewayId the gateway identifier
     * @return the Layer2Gateway or null if not found
     */
    Layer2Gateway get(String gatewayId);

    /**
     * Delete a Layer2Gateway by ID
     *
     * @param gatewayId the gateway identifier to delete
     * @return the action response
     */
    ActionResponse delete(String gatewayId);

    /**
     * Creates a new Layer2Gateway
     * @param gateway the Layer2Gateway to create
     * @return the newly created Layer2Gateway
     */
    Layer2Gateway create(Layer2Gateway gateway);

    /**
     * Updates an existing Layer2Gateway.  The Layer2Gateway identifier must be set on the gateway object to be successful
     * @param gateway the Layer2Gateway to update
     * @return the updated Layer2Gateway
     */
    Layer2Gateway update(Layer2Gateway gateway);
}
