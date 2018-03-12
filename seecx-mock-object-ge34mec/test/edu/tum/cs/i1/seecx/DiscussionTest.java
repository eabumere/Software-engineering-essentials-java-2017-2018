package edu.tum.cs.i1.seecx;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(EasyMockRunner.class)
public class DiscussionTest {

	@TestSubject
	private Discussion discussion = new Discussion();
	
	@Mock
	private Course courseMock;
	@Mock 
	private Comment commentMock;

	@Test
	public void testComment() {
		int initialNr = discussion.getNumberOfComments();
		expect(commentMock.save()).andReturn(true);
		replay(commentMock);
		discussion.addComment(commentMock);
		assertEquals(initialNr + 1, discussion.getNumberOfComments());
	}

	@Test 
	public void testCommentIfSavingFails() {
		int initialNr = discussion.getNumberOfComments();
		expect(commentMock.save()).andReturn(false);
		replay(commentMock);
		discussion.addComment(commentMock);
		assertEquals(initialNr, discussion.getNumberOfComments());
	}

	@Test
	public void testStartCourseDiscussion() {
		String topic = "Exams";
		Person person = new Lecturer("Uncle", "Ben", "1943");
		expect(courseMock.isDiscussionAllowed(person)).andReturn(true);
		replay(courseMock);
		discussion.startCourseDiscussion(courseMock, person, topic);
		assertEquals("Course not set correctly", courseMock, discussion.getCourse());
		assertEquals("Topic not set correctly", topic, discussion.getTopic());
	}

}
