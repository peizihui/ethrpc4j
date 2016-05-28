package org.chatch.ethrpc4j.methods;

import static org.chatch.ethrpc4j.databind.Converters.*;

import java.util.List;

import org.chatch.ethrpc4j.rpc.RpcProvider;
import org.chatch.ethrpc4j.types.Block;
import org.chatch.ethrpc4j.types.Log;
import org.chatch.ethrpc4j.types.Syncing;
import org.chatch.ethrpc4j.types.Transaction;

public class EthMethods extends MethodsBase {

	private static final String METHOD_PREFIX = "eth";

	public EthMethods(RpcProvider provider) {
		super(METHOD_PREFIX, provider);
	}

	public Long protocolVersion() throws Exception {
		return callQuantity("protocolVersion");
	}

	public Syncing syncing() throws Exception {
		return (Syncing) call("syncing", null, Syncing.class);
	}

	public String coinbase() throws Exception {
		return callString("coinbase");
	}

	public Boolean mining() throws Exception {
		return callBoolean("mining");
	}

	public Long hashrate() throws Exception {
		return callQuantity("hashrate", null);
	}

	public Long gasPrice() throws Exception {
		return callQuantity("gasPrice");
	}

	public String[] accounts() throws Exception {
		return (String[]) call("accounts", null, String[].class);
	}

	public Long blockNumber() throws Exception {
		return callQuantity("blockNumber");
	}

	public Long getBalance(Long address, Long block) throws Exception {
		return callQuantity("getBalance", new Object[] { address, block });
	}

	public Long getBalance(Long address) throws Exception {
		return callQuantity("getBalance", new Object[] { address });
	}

	public String getStorageAt(String address, String storageIdx, String blockId) throws Exception {
		return callString("getStorageAt", new Object[] { address, storageIdx, blockId });
	}

	public Long getTransactionCount(Long address, Long blockId) throws Exception {
		return callQuantity("getTransactionCount", new Object[] { address, blockId });
	}

	public Long getBlockTransactionCountByHash(Long blockHash) throws Exception {
		return callQuantity("getBlockTransactionCountByHash", new Object[] { blockHash });
	}

	public Long getBlockTransactionCountByNumber(Long bnOrId) throws Exception {
		return callQuantity("getBlockTransactionCountByNumber", new Object[] { bnOrId });
	}

	public Long getUncleCountByBlockHash(Long blockHash) throws Exception {
		return callQuantity("getUncleCountByBlockHash", new Object[] { blockHash });
	}

	public Long getUncleCountByBlockNumber(Long bnOrId) throws Exception {
		return callQuantity("getUncleCountByBlockNumber", new Object[] { bnOrId });
	}

	public String getCode(String addr, String bnOrId) throws Exception {
		return callString("getCode", new Object[] { addr, bnOrId });
	}

	public String sign(String addr, String data) throws Exception {
		return callString("sign", new Object[] { addr, data });
	}

	public String sendTransaction(String from, String to, String gas, String gasPrice, String value, String data,
			String nonce) throws Exception {
		return callString("sendTransaction", new Object[] { from, to, gas, gasPrice, value, data, nonce });
	}

	public String sendRawTransaction(String rawData) throws Exception {
		return callString("sendRawTransaction", new Object[] { rawData });
	}

	public String call(String from, String to, String gas, String gasPrice, String value, String data)
			throws Exception {
		return callString("call", new Object[] { from, to, gas, gasPrice, value, data });
	}

	public Long estimateGas(Long from, Long to, Long gas, Long gasPrice, Long value, Long data) throws Exception {
		return callQuantity("estimateGas", new Object[] { from, to, gas, gasPrice, value, data });
	}

	public Block getBlockByHash(String blockHash, Boolean fullTransactionObjects) throws Exception {
		return (Block) call("getBlockByHash", new Object[] { blockHash, fullTransactionObjects }, Block.class);
	}

	public Block getBlockByNumber(String bnOrId, Boolean fullTransactionObjects) throws Exception {
		return (Block) call("getBlockByNumber", new Object[] { bnOrId, fullTransactionObjects }, Block.class);
	}

	public Transaction getTransactionByHash(String transactionHash) throws Exception {
		return (Transaction) call("getTransactionByHash", new Object[] { transactionHash }, Transaction.class);
	}

	public Transaction getTransactionByBlockHashAndIndex(String blockHash, String index) throws Exception {
		return (Transaction) call("getTransactionByBlockHashAndIndex", new Object[] { blockHash, index },
				Transaction.class);
	}

	public Transaction getTransactionByBlockNumberAndIndex(String bnOrId, String index) throws Exception {
		return (Transaction) call("getTransactionByBlockNumberAndIndex", new Object[] { bnOrId, index },
				Transaction.class);
	}

	public Transaction getTransactionReceipt(String transactionHash) throws Exception {
		return (Transaction) call("getTransactionReceipt", new Object[] { transactionHash }, Transaction.class);
	}

	public Block getUncleByBlockHashAndIndex(String blockHash, String uncleIdx) throws Exception {
		return (Block) call("getUncleByBlockHashAndIndex", new Object[] { blockHash, uncleIdx }, Block.class);
	}

	public Block getUncleByBlockNumberAndIndex(String blockId, String uncleIdx) throws Exception {
		return (Block) call("getUncleByBlockNumberAndIndex", new Object[] { blockId, uncleIdx }, Block.class);
	}

	public String[] getCompilers() throws Exception {
		return (String[]) call("getCompilers", null, String[].class);
	}

	public byte[] compileLLL(String contract) throws Exception {
		return (byte[]) call("compileLLL", new Object[] { contract }, byte[].class);
	}

	public byte[] compileSolidity(String contract) throws Exception {
		return (byte[]) call("compileSolidity", new Object[] { contract }, byte[].class);
	}

	public byte[] compileSerpent(String contract) throws Exception {
		return (byte[]) call("compileSerpent", new Object[] { contract }, byte[].class);
	}

	public Long newFilter(String fromBlock, String toBlock, String address, String[] topics) throws Exception {
		return callQuantity("newFilter", new Object[] { fromBlock, toBlock, address, topics });
	}

	public Long newBlockFilter() throws Exception {
		return callQuantity("newBlockFilter");
	}

	public Long newPendingTransactionFilter() throws Exception {
		return callQuantity("newPendingTransactionFilter");
	}

	public Boolean uninstallFilter(Long filterId) throws Exception {
		return callBoolean("uninstallFilter", new Object[] { quantityToHex(filterId) });
	}

	@SuppressWarnings("unchecked")
	public List<Log> getFilterChanges(Long filterId) throws Exception {
		return (List<Log>) call("getFilterChanges", new Object[] { quantityToHex(filterId) }, List.class);
	}

	@SuppressWarnings("unchecked")
	public List<Log> getFilterLogs(Long filterId) throws Exception {
		return (List<Log>) call("getFilterLogs", new Object[] { quantityToHex(filterId) }, List.class);
	}

	@SuppressWarnings("unchecked")
	public List<Log> getLogs(String fromBlock, String toBlock, String address, String[] topics) throws Exception {
		return (List<Log>) call("getLogs", new Object[] { fromBlock, toBlock, address, topics }, List.class);
	}

	public String[] getWork() throws Exception {
		return (String[]) call("getWork", null, String[].class);
	}

	public Boolean submitWork(String nonce, String powHash, String mixDigest) throws Exception {
		return callBoolean("submitWork", new Object[] { nonce, powHash, mixDigest });
	}

	public Boolean submitHashrate(String hashRate, String clientId) throws Exception {
		return callBoolean("submitHashrate", new Object[] { hashRate, clientId });
	}

}
