package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.Layer2GatewayService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.Layer2Gateway;
import org.openstack4j.model.network.Layer2GatewayWrapper;
import org.openstack4j.openstack.networking.domain.NeutronLayer2Gateway;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Layer2GatewayServiceImpl extends BaseNetworkingServices implements Layer2GatewayService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Layer2Gateway> list() {
        return get(NeutronLayer2Gateway.Gateways.class, uri("/l2-gateways")).execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Layer2Gateway get(String gatewayId) {
        checkNotNull(gatewayId);
        return get(Layer2GatewayWrapper.class, uri("/l2-gateways/%s", gatewayId)).execute().getGateway();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse delete(String gatewayId) {
        checkNotNull(gatewayId);
        return deleteWithResponse(uri("/l2-gateways/%s", gatewayId)).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Layer2Gateway create(Layer2Gateway gateway) {
        checkNotNull(gateway);
        return post(Layer2GatewayWrapper.class, uri("/l2-gateways"))
                .entity(new Layer2GatewayWrapper(gateway))
                .execute()
                .getGateway();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Layer2Gateway update(Layer2Gateway gateway) {
        checkNotNull(gateway);
        checkNotNull(gateway.getId());
        Layer2Gateway p = gateway.toBuilder()
                .tenantId(null)
                .build();
        return put(Layer2GatewayWrapper.class, uri("/l2-gateways/%s", getAndClearIdentifier(p)))
                .entity(new Layer2GatewayWrapper(p))
                .execute()
                .getGateway();
    }

    private String getAndClearIdentifier(Layer2Gateway gateway) {
        String portId = gateway.getId();
        gateway.setId(null);
        return portId;
    }
}
