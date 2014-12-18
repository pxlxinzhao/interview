package hibernate;

import java.util.List;

import model.Identity_dating;
import model.Identity_message;
import model.Users;

public interface HibernateHelper {

	public abstract List<Identity_message> getMessagebyRecipientId(
			int RecipientId, String type);

	public abstract List<Identity_message> getMessagebySenderAndRecipient(
			int SenderId, int RecipientId, String type);

	public abstract List<Identity_message> getRecentMessagebyRecipient(
			int RecipientId, String type);

	public abstract void saveUser(Users user);

	public abstract void saveIdentity_message(Identity_message message);

	public abstract Users getUserByName(String username);

	public abstract Users getUserById(int Id);

	public abstract Users getSenderIdByName(String username);

	public abstract Identity_dating getDatingUserIdentityByUserId(int userId);

	public abstract void saveIdd(Identity_dating idd);

}