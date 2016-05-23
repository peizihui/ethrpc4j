package org.chatch.ethrpc4j.mapping;

import org.chatch.ethrpc4j.mapping.deserialize.BlockDeserializer;
import org.chatch.ethrpc4j.mapping.deserialize.TransactionDeserializer;
import org.chatch.ethrpc4j.types.Block;
import org.chatch.ethrpc4j.types.Transaction;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class EthRpc4JModule extends SimpleModule {

	private static final long serialVersionUID = -4840495639824086987L;

	public EthRpc4JModule() {
		addDeserializer(Block.class, new BlockDeserializer());
		addDeserializer(Transaction.class, new TransactionDeserializer());
	}

	@Override
	public String getModuleName() {
		return getClass().getSimpleName();
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return this == o;
	}
}
