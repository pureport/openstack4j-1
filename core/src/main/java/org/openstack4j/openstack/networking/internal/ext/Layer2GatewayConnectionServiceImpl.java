package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.Layer2GatewayConnectionService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.Layer2GatewayConnection;
import org.openstack4j.model.network.Layer2GatewayConnectionWrapper;
import org.openstack4j.model.network.Layer2GatewayWrapper;
import org.openstack4j.openstack.networking.domain.NeutronLayer2GatewayConnection;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Layer2GatewayConnectionServiceImpl extends BaseNetworkingServices implements Layer2GatewayConnectionService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Layer2GatewayConnection> list() {
        return get(
                NeutronLayer2GatewayConnection.GatewayConnections.class,
                uri("/l2-gateway-connections")
        ).execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Layer2GatewayConnection get(String gatewayConnectionId) {
        checkNotNull(gatewayConnectionId);
        return get(Layer2GatewayConnectionWrapper.class, uri("/l2-gateway-connections/%s", gatewayConnectionId))
                .execute()
                .getConnection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse delete(String gatewayConnectionId) {
        checkNotNull(gatewayConnectionId);
        return deleteWithResponse(uri("/l2-gateway-connections/%s", gatewayConnectionId)).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Layer2GatewayConnection create(Layer2GatewayConnection connection) {
        checkNotNull(connection);
        return post(Layer2GatewayConnectionWrapper.class, uri("/l2-gateway-connections"))
                .entity(new Layer2GatewayConnectionWrapper(connection))
                .execute()
                .getConnection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Layer2GatewayConnection update(Layer2GatewayConnection connection) {
        checkNotNull(connection);
        checkNotNull(connection.getId());
        Layer2GatewayConnection c = connection.toBuilder()
                .tenantId(null)
                .build();
        return put(Layer2GatewayConnectionWrapper.class, uri("/l2-gateway-connections/%s", getAndClearIdentifier(c)))
                .entity(new Layer2GatewayConnectionWrapper(c))
                .execute()
                .getConnection();
    }

    private String getAndClearIdentifier(Layer2GatewayConnection connection) {
        String portId = connection.getId();
        connection.setId(null);
        return portId;
    }
}
