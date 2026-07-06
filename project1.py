# -----------------------------------------
# DecodeLabs - Artificial Intelligence
# Project 1: Rule-Based AI Chatbot
# Developed by: Anusha
# -----------------------------------------

def chatbot():
    print("=" * 60)
    print("        WELCOME TO RULE-BASED AI CHATBOT")
    print("=" * 60)
    print("Type 'exit' or 'bye' anytime to end the conversation.\n")

    while True:
        user_input = input("You : ").strip().lower()

        # Greetings
        if user_input in ["hi", "hello", "hey", "good morning", "good evening"]:
            print("Bot : Hello! Welcome. How can I assist you today?\n")

        # Introduction
        elif user_input in ["who are you", "what is your name"]:
            print("Bot : I am a Rule-Based AI Chatbot developed using Python.\n")

        # Asking about chatbot
        elif user_input == "how are you":
            print("Bot : I am functioning perfectly. Thank you for asking!\n")

        # AI Information
        elif user_input == "what is ai":
            print("Bot : AI stands for Artificial Intelligence, which enables machines to perform tasks that normally require human intelligence.\n")

        # Python Information
        elif user_input == "what is python":
            print("Bot : Python is a simple, powerful, and widely used programming language.\n")

        # DecodeLabs
        elif user_input == "decodelabs":
            print("Bot : DecodeLabs provides industry-oriented training and internship programs.\n")

        # Help
        elif user_input == "help":
            print("Bot : You can ask me questions like:")
            print("      • What is AI")
            print("      • What is Python")
            print("      • Who are you")
            print("      • How are you")
            print("      • DecodeLabs\n")

        # Thank You
        elif user_input in ["thanks", "thank you"]:
            print("Bot : You're welcome! Happy to help.\n")

        # Exit
        elif user_input in ["bye", "exit", "quit"]:
            print("Bot : Thank you for chatting with me.")
            print("Bot : Have a wonderful day!")
            break

        # Unknown Input
        else:
            print("Bot : Sorry, I don't understand your question.")
            print("Bot : Please type 'help' to know what you can ask.\n")


# Program Execution
if __name__ == "__main__":
    chatbot()