package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashSet;
import java.util.Set;

/**
 * Prover caller that implements a timeout after which the proving process should be aborted.
 * 
 * @author Leon Handreke
 */
public abstract class TimeoutProverCaller implements ProverCaller {

	/**
	 * time in milliseconds after which to return with an UNKNOWN result if no proof has been found.
	 */
	private int timeout;

	/**
	 * @return the timeout
	 */
	public final int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *                the timeout to set
	 */
	public final void setTimeout(final int timeout) {
		this.timeout = timeout;
	}

	/**
	 * The set of tasks to be run after a timeout occurs.
	 */
	private Set<Runnable> cleanupTasks = new HashSet<Runnable>();

	/**
	 * Add a cleanup task to be run after the timeout occurs.
	 * 
	 * @param cleanupTask
	 *                the cleanup task to add
	 */
	public final void addCleanupTask(final Runnable cleanupTask) {
		this.cleanupTasks.add(cleanupTask);
	}

	/**
	 * Run all scheduled cleanup tasks.
	 */
	private void runCleanupTasks() {
		for (Runnable task : this.cleanupTasks) {
			task.run();
		}
	}

	/**
	 * @param timeout
	 *                time in milliseconds after which to return with an UNKNOWN result if no proof has been found
	 */
	public TimeoutProverCaller(final int timeout) {
		this.timeout = timeout;
	}

	/**
	 * Schedule cleanup tasks after the given timeout.
	 */
	protected final void scheduleProverCallerTimeout() {
		// thread that kills the prover after timeout
		Thread killerThread = new Thread() {
			public void run() {
				try {
					Thread.sleep(TimeoutProverCaller.this.timeout);
				} catch (InterruptedException e) {
					TimeoutProverCaller.this.runCleanupTasks();
				} finally {
					TimeoutProverCaller.this.runCleanupTasks();
				}
			};
		};
		killerThread.start();
	}
}
