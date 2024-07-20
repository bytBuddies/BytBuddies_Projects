USE [emsDatabase]
GO

/****** Object:  Table [dbo].[user_role_table]    Script Date: 16-07-2024 18:28:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_role_table](
	[id] [varchar](50) NOT NULL,
	[role] [varchar](20) NOT NULL
) ON [PRIMARY]
GO

INSERT INTO [dbo].[user_role_table] (id, role)
VALUES
  ('303d6c62-e132-49fb-8e83-cc7e877a23c1', 'Admin'),
  ('b35774e0-eeef-45a4-a8f3-0ddfa676ba28', 'HR Administrator'),
  ('58c83b60-6ec8-4efb-bd18-3fc46003568f', 'Team Lead'),
  ('0b8ea92e-ad81-44e2-9c86-20a241b33fe1', 'IT Administrator'),
  ('27dee5e2-91bd-40e3-86a6-d12254a668eb', 'Developer'),
  ('02ec1d76-188a-43c2-99c7-e1183b550047', 'Candidate'),
  ('8815a4e2-8e13-404c-bb92-ddb03647f867', 'Manager');
GO

